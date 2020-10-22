package br.com.zup.validation;

import br.com.zup.annotation.NomeUnico;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class NomeUnicoValidator implements ConstraintValidator {
    private String campo;
    private Class<?> klass;

    @Override
    public void initialize(NomeUnico nomeUnico) {
        campo = nomeUnico.fieldName();
        klass = nomeUnico.domainClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

    }
}
