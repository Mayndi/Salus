package com.platform.salus.common.utils;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationUtils {

    @Autowired
    private Internationalization messagesBundle;

    public static final int MAX_PAGE_SIZE = 25;

    public static void checkEmptyObject(Object object, String messageIfError) throws InvalidInformationException {
        if (object == null)
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkEmptyString(String string, String messageIfError) throws InvalidInformationException {
        if (string == null || string.trim().equals(""))
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkValidPage(Long page, String messageIfError) throws InvalidPageRequestException {
        if (page == null || page < 0)
            throw new InvalidPageRequestException(messageIfError);
    }

    public static void checkValidCount(Long count, String messageIfError) throws InvalidPageRequestException {
        if (count == null || count > MAX_PAGE_SIZE || count <= 0)
            throw new InvalidPageRequestException(messageIfError);
    }

    public static void checkDate(String date, String messageIfError) throws InvalidInformationException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(date);
        } catch (ParseException ex) {
            throw new InvalidInformationException(messageIfError);
        }
    }

    public static void checkEmail(String email, String messageIfError) throws InvalidInformationException {
        try {
            InternetAddress emailCheck = new InternetAddress(email);
            emailCheck.validate();
        } catch (AddressException ex) {
            throw new InvalidInformationException(messageIfError);
        }
    }

    public static void checkCpf(String cpf, String messageIfError) throws InvalidInformationException {
        String cpfCheck = cpf.replace(".", "").replace("-", "");
        if (cpfCheck.length() != 11 || cpfCheck == null)
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkCnpj(String cnpj, String messageIfError) throws InvalidInformationException {
        String cnpjCheck = cnpj.replace(".", "").replace("-", "").replace("/", "");;
        if (cnpjCheck.length() != 14 || cnpjCheck == null)
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkSus(String nSus, String messageIfError) throws InvalidInformationException {
        String nSusCheck = nSus.replace(".", "").replace("-", "");
        if (nSusCheck.length() != 15 || nSus == null)
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkCep(String cep, String messageIfError) throws InvalidInformationException {
        String cepCheck = cep.replace(".", "").replace("-", "");
        if (cepCheck.length() != 8 || cep == null)
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkFone(String telefone, String messageIfError) throws InvalidInformationException {
        String telefoneCheck = telefone.replace(".", "").replace("-", "").replace("(", "").replace(")", "");
        if (telefoneCheck.length() < 10 || telefone == null)
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkpass(String senha, String confSenha, String messageIfError) throws InvalidInformationException {
        if (senha.length() != confSenha.length() || senha == null || confSenha == null)
            throw new InvalidInformationException(messageIfError);
    }

    public static void checkValidBoolean(String bool, String messageIfError) throws InvalidInformationException {
        try {
            Boolean.valueOf(bool);
        } catch (Exception ex) {
            throw new InvalidInformationException(messageIfError);
        }
    }
}
