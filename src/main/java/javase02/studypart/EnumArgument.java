package javase02.studypart;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * Annotation for indicating availability some argument for enum
 * */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumArgument {
    String argument() default "index";
}
