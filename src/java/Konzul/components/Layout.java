/*
 * Layout.java
 * Created 10.06.2012.
 */
package Konzul.components;

import Konzul.entities.Korisnik;
import Konzul.entities.TipKorisnika;
import Konzul.pages.index;
import java.text.DateFormat;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.runtime.Component;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.services.PersistentLocale;
import org.apache.tapestry5.ioc.annotations.Symbol;
/**
 * @author Vladislav Dragosavac
 */
@IncludeStylesheet("context:css/style.css")
 public class Layout {
    @Inject
    private ComponentResources resources;
    @Parameter(required = true, defaultPrefix = "literal")
    private String pageTitle;
    @InjectPage
    private index home;
    @ApplicationState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;
	// Screen fields

	@Inject
	@Property
	private Locale currentLocale;

	@Property
	@SuppressWarnings("unused")
	private Date date;

	@Property
	@SuppressWarnings("unused")
	private double number = 1234.56;

	@Property
	@SuppressWarnings("unused")
	private DateFormat dateFormat;

	@Property
	@SuppressWarnings("unused")
	private NumberFormat numberFormat;

	@Property
	@SuppressWarnings("unused")
	private List<Locale> supportedLocales;

	@Property
	@SuppressWarnings("unused")
	private Locale supportedLocale;

	// Generally useful bits and pieces

	@Inject
	private PersistentLocale persistentLocaleService;

	@Inject
	@Symbol("tapestry.supported-locales")
	private String supportedLocalesString;

	// The code

	void setupRender() {
		supportedLocales = LocalesUtil.convertToLocales(supportedLocalesString);
		date = new Date();
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG, currentLocale);
		numberFormat = NumberFormat.getInstance(currentLocale);
	}
    /**
     * Metoda getAdmin
     * @return true or false
     */
    public boolean getAdmin(){
        if(asoKorisnikExists)
            if(asoKorisnik.getKorisnikRola() == TipKorisnika.ADMIN)
                return true;
        return false;
    }

    /**
     * Metoda getUser
     * @return true or false
     */
    public boolean getKonzul(){
        if(asoKorisnikExists)
            if(asoKorisnik.getKorisnikRola() == TipKorisnika.KONZUL)
                return true;
        return false;
    }
    public boolean getUser(){
        if(asoKorisnikExists)
            if(asoKorisnik.getKorisnikRola() == TipKorisnika.USER)
                return true;
        return false;
    }


    /**
     * Metoda onActionFromLogout
     * @return home
     */
    public Object onActionFromLogout() {
        asoKorisnik = null;
        return home;
    }

    /**
     * Metoda getPageTitle
     * @return pageTitle
     */
    public String getPageTitle() {
        return pageTitle;
    }

    /**
     * Metoda getPageName
     * @return pageTitle
     */
    private String getPageName() {
        Component page = resources.getContainer();
        return page.getClass().getName();
    }


    /**
     * Metoda getDatum
     * @return 
     */
    public String getDatum(){
        Format f = new SimpleDateFormat("dd.MM.yyyy");
        return f.format(new Date());
    }
    void onSwitchLocale(String localeCode) {
		persistentLocaleService.set(LocalesUtil.convertToLocale(localeCode));
    }
}
