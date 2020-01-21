package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Computer;
import objects.Hardware;
import objects.Printer;
import objects.Room;

import java.time.LocalDate;

/**
 *
 */
public class DaoManager
{
	
	private static DaoManager daomanager = null;
	
	private ObservableList<Hardware> liste_drucker = null;
	private ObservableList<Hardware> liste_rechner = null;
	private ObservableList<Room> liste_raum = null;
	
	/**
	 *
	 */
	private DaoManager()
	{
		this.liste_raum = FXCollections.observableArrayList();
		this.loadRaeume();
		
		this.liste_drucker = FXCollections.observableArrayList();
		this.loadDrucker();
		
		this.liste_rechner = FXCollections.observableArrayList();
		this.loadRechner();
	}
	
	/**
	 * @return
	 */
	public static DaoManager getInstance()
	{
		if (DaoManager.daomanager == null)
		{
			DaoManager.daomanager = new DaoManager();
		}
		return daomanager;
	}
	
	/**
	 * @return
	 */
	public ObservableList<Hardware> getListe_drucker()
	{
		return liste_drucker;
	}
	
	/**
	 * @return
	 */
	public ObservableList<Hardware> getListe_rechner()
	{
		return liste_rechner;
	}
	
	/**
	 * @return
	 */
	public ObservableList<Room> getListe_raum()
	{
		return liste_raum;
	}
	
	/**
	 *
	 */
	private void loadRaeume()
	{
		Room raum = null;
		
		raum = new Room("A120",
						"IT Fachraum",
						80.0);
		this.liste_raum.add(raum);
		
		raum = new Room("A122",
						"IT Fachraum",
						85.0);
		this.liste_raum.add(raum);
		
		raum = new Room("A123",
						"IT Fachraum",
						83.0);
		this.liste_raum.add(raum);
	}
	
	/**
	 *
	 */
	private void loadDrucker()
	{
		Hardware hardware = null;
		hardware = new Printer("D1001",
							   "HP DeskJet 2630",
							   "HP",
							   "Ok",
							   12,
							   LocalDate.now(),
							   "Tintenstrahldrucker",
							   true,
							   "A4",
							   this.getRaumByID("A120"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D1002",
							   "HP DeskJet 2630",
							   "HP",
							   "ok",
							   12,
							   LocalDate.now(),
							   "Tintenstrahldrucker",
							   true,
							   "A4",
							   this.getRaumByID("A122"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D1003",
							   "HP DeskJet 2630",
							   "HP",
							   "ok",
							   12,
							   LocalDate.now(),
							   "Tintenstrahldrucker",
							   true,
							   "A4",
							   this.getRaumByID("A123"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D2001",
							   "Samsung XPRESS C480FW",
							   "Samsung",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Farblaserdrucker",
							   true,
							   "A4",
							   this.getRaumByID("A120"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D2002",
							   "Samsung XPRESS C480FW",
							   "Samsung",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Farblaserdrucker",
							   true,
							   "A4",
							   this.getRaumByID("A122"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D2003",
							   "Samsung XPRESS C480FW",
							   "Samsung",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Farblaserdrucker",
							   true,
							   "A4",
							   this.getRaumByID("A123"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D3001",
							   "Brother MFC-J6930DW",
							   "Brother",
							   "ok",
							   36,
							   LocalDate.now(),
							   "Farbtintenstrahldrucker",
							   true,
							   "A3",
							   this.getRaumByID("A120"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D3002",
							   "Brother MFC-J6930DW",
							   "Brother",
							   "ok",
							   36,
							   LocalDate.now(),
							   "Farbtintenstrahldrucker",
							   true,
							   "A3",
							   this.getRaumByID("A122"));
		this.liste_drucker.add(hardware);
		hardware = new Printer("D3003",
							   "Brother MFC-J6930DW",
							   "Brother",
							   "ok",
							   36,
							   LocalDate.now(),
							   "Farbtintenstrahldrucker",
							   true,
							   "A3",
							   this.getRaumByID("A123"));
		this.liste_drucker.add(hardware);
	}
	
	/**
	 *
	 */
	private void loadRechner()
	{
		Hardware hardware = null;
		hardware = new Computer("R1001",
							   "Acer Aspire XC-885",
							   "Acer",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Intel Core i5-8400",
							   8,
							   "Windwos 10 Home 64 bit",
							   "Multimedia-PC",
							   "Nvidia GeForce GT 1030",
							   128,
							   1,
							   this.getRaumByID("A120"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R1002",
							   "Acer Aspire XC-885",
							   "Acer",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Intel Core i5-8400",
							   8,
							   "Windwos 10 Home 64 bit",
							   "Multimedia-PC",
							   "Nvidia GeForce GT 1030",
							   128,
							   1,
							   this.getRaumByID("A122"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R1003",
							   "Acer Aspire XC-885",
							   "Acer",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Intel Core i5-8400",
							   8,
							   "Windwos 10 Home 64 bit",
							   "Multimedia-PC",
							   "Nvidia GeForce GT 1030",
							   128,
							   1,
							   this.getRaumByID("A123"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R2001",
							   "GeForce GTX 1050",
							   "GeForce",
							   "ok",
							   36,
							   LocalDate.now(),
							   "AMD FX-6300",
							   8,
							   "Windwos 10 64 bit",
							   "Gaming-PC",
							   "Nvidia GeForce GTX1050",
							   0,
							   1,
							   this.getRaumByID("A120"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R2002",
							   "GeForce GTX 1050",
							   "GeForce",
							   "ok",
							   36,
							   LocalDate.now(),
							   "AMD FX-6300",
							   8,
							   "Windwos 10 64 bit",
							   "Gaming-PC",
							   "Nvidia GeForce GTX1050",
							   0,
							   1,
							   this.getRaumByID("A122"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R2003",
							   "GeForce GTX 1050",
							   "GeForce",
							   "ok",
							   36,
							   LocalDate.now(),
							   "AMD FX-6300",
							   8,
							   "Windwos 10 64 bit",
							   "Gaming-PC",
							   "Nvidia GeForce GTX1050",
							   0,
							   1,
							   this.getRaumByID("A123"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R3001",
							   "Apple Mac Mini",
							   "Apple",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Intel Core i3-8100B",
							   8,
							   "macOS 10.14 Mojave 64 bit",
							   "Multimedia-PC",
							   "Intel UHD Graphics 630",
							   128,
							   0,
							   this.getRaumByID("A120"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R3002",
							   "Apple Mac Mini",
							   "Apple",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Intel Core i3-8100B",
							   8,
							   "macOS 10.14 Mojave 64 bit",
							   "Multimedia-PC",
							   "Intel UHD Graphics 630",
							   128,
							   0,
							   this.getRaumByID("A122"));
		this.liste_rechner.add(hardware);
		hardware = new Computer("R3003",
							   "Apple Mac Mini",
							   "Apple",
							   "ok",
							   24,
							   LocalDate.now(),
							   "Intel Core i3-8100B",
							   8,
							   "macOS 10.14 Mojave 64 bit",
							   "Multimedia-PC",
							   "Intel UHD Graphics 630",
							   128,
							   0,
							   this.getRaumByID("A123"));
		this.liste_rechner.add(hardware);
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Room getRaumByID(String id)
	{
		Room work = null;
		
		for (Room element : this.liste_raum)
		{
			if (element.getId().equals(id))
			{
				work = element;
			}
		}
		
		return work;
	}
	
}
