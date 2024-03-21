package server.desdent.service;

import org.springframework.stereotype.Service;
import server.desdent.exception.BadRequestException;
import server.desdent.exception.NotFoundException;
import server.desdent.exception.UnauthorizedException;
import server.desdent.model.dto.user.*;
import server.desdent.model.pojo.Dentists;
import server.desdent.utility.DentistsUtility;

@Service
public class DentistsService extends AbstractService {

    public DentistWithoutPasswordDTO login(LoginRequestDentistDTO dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        Dentists dentistsFromDb = dentistsRepository.findByUsername(username);
        if (dentistsFromDb == null || !passwordEncoder.matches(password, dentistsFromDb.getPassword())) {
            throw new BadRequestException("Неправилно име или парола!");
        }
        return modelMapper.map(dentistsFromDb, DentistWithoutPasswordDTO.class);
    }

    public DentistWithoutPasswordDTO forgottenPassword(ForgottenPassDTO dto) {
        String email = dto.getEmail();
        Dentists dentists = dentistsRepository.findByEmail(email);
        if (dentists == null) {
            throw new NotFoundException("Няма намерен потребител!!");
        }
        String password = DentistsUtility.generateRandomPassword();
        if (!DentistsUtility.isValidPass(password)) {
            throw new BadRequestException("Bad password generated!");
        }
        String msg = "Вашата автоматично генерира парола е: \n " +
                password + " \n" +
                "Може да я смените по всяко време от настройките.";
        new Thread(() -> emailService.sendSimpleMessage(email, "Възстановяване на парола", msg)).start();
        dentists.setPassword(passwordEncoder.encode(password));
        return modelMapper.map(dentistsRepository.save(dentists), DentistWithoutPasswordDTO.class);
    }

    public DentistWithoutPasswordDTO editUserPassword(long id, EditPasswordRequestDTO dto) {
        Dentists dentist = dentistsRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));
        String oldPass = dto.getOldPassword();
        String newPass = dto.getNewPassword();
        String newConfirmPass = dto.getConfirmNewPassword();
        boolean oldPassMatches = passwordEncoder.matches(oldPass, dentist.getPassword());
        boolean newPassConfirmed = DentistsUtility.passwordsMatch(newPass, newConfirmPass);
        boolean newPassIsValid = DentistsUtility.isValidPass(newPass);
        if (!oldPassMatches) {
            throw new UnauthorizedException("Грешна парола!");
        }
        if (!newPassIsValid) {
            throw new BadRequestException("Невалидна парола!");
        }
        if (!newPassConfirmed) {
            throw new BadRequestException("Паролите не съвпадат!");
        }
        dentist.setPassword(passwordEncoder.encode(newPass));
        dentist = dentistsRepository.save(dentist);
        return modelMapper.map(dentist, DentistWithoutPasswordDTO.class);
    }

    public DentistWithoutPasswordDTO editUserData(Long id, EditUserRequestDTO dto) {
        Dentists dentists = dentistsRepository.findById(id).orElseThrow(() -> new NotFoundException("Няма намерен потребител!"));
        String mobilePhone = dto.getPhoneNum();
        if (mobilePhone != null) {
            int l = mobilePhone.length();
            if (dentistsRepository.findByPhoneNumContaining(mobilePhone.substring(l - 9, l - 1)).isPresent()) {
                throw new BadRequestException("Дубликиран мобилен номер!");
            }
            if (!DentistsUtility.isValidMobilePhone(mobilePhone)) {
                throw new BadRequestException("Невалиден мобилен номер!");
            }
            dentists.setPhoneNum(mobilePhone);
        }
        String nickname = dto.getUsername();
        if (nickname != null) {
            if (nickname.trim().length() <= 1 || nickname.trim().length() > 45) {
                throw new BadRequestException("Потребителското име трябва да бъде между 2 и 45 символа");
            }
            dentists.setUsername(nickname);
        }
        String email = dto.getEmailAddress();
        if (email != null) {
            if (dentistsRepository.findByEmail(email) != null) {
                throw new BadRequestException("Имейлът вече същестува!");
            }
            if (!DentistsUtility.isValidEmail(email)) {
                throw new BadRequestException("Невалиден имейл!");
            }
            dentists.setEmail(email);
        }
        dentists = dentistsRepository.save(dentists);
        return modelMapper.map(dentists, DentistWithoutPasswordDTO.class);

    }



}
