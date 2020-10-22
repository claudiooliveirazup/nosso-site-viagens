package br.com.zup.validation;

import br.com.zup.annotation.NomeUnico;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.List;

public class NomeUnicoValidator implements ConstraintValidator<NomeUnico, String> {
    private String campo;
    private Class<?> klass;

    @PersistenceContext
    EntityManager manager;

    @Override
    public void initialize(NomeUnico nomeUnico) {
        campo = nomeUnico.fieldName();
        klass = nomeUnico.domainClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Strings.isBlank(value)) return true;

        Query query = manager.createQuery(
                "select 1 from " + klass.getName() + " where " + campo + " = :valor"
        );
        query.setParameter("valor", value);

        List<?> resultado = query.getResultList();
        return resultado.isEmpty();
    }
}
