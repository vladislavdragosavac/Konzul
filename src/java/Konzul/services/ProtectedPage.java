/*
 * ProtectedPage.java
 * Created 1.6.2012.
 */

package Konzul.services;

import Konzul.entities.TipKorisnika;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * @author Vladislav Dragosavac
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ProtectedPage {

    TipKorisnika getRole() default TipKorisnika.NONE;
}
