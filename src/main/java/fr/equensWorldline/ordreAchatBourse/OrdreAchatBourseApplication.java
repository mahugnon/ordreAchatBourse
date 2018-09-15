package fr.equensWorldline.ordreAchatBourse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.equensWorldline.ordreAchatBourse.entities.Role;
import fr.equensWorldline.ordreAchatBourse.entities.Tarification;
import fr.equensWorldline.ordreAchatBourse.metier.IMetierClientImpl;
import fr.equensWorldline.ordreAchatBourse.entities.AppUser;
import fr.equensWorldline.ordreAchatBourse.entities.Client;
import fr.equensWorldline.ordreAchatBourse.entities.CompteBanquaire;
import fr.equensWorldline.ordreAchatBourse.entities.Instrument;
import fr.equensWorldline.ordreAchatBourse.repository.RoleRepository;
import fr.equensWorldline.ordreAchatBourse.repository.TarificationRepository;
import fr.equensWorldline.ordreAchatBourse.repository.AppUserRepository;
import fr.equensWorldline.ordreAchatBourse.repository.ClientRepository;
import fr.equensWorldline.ordreAchatBourse.repository.CompteBanquaireRepository;
import fr.equensWorldline.ordreAchatBourse.repository.InstrumentRepository;

@SpringBootApplication
public class OrdreAchatBourseApplication implements CommandLineRunner {
@Autowired
AppUserRepository userRepository;
@Autowired
RoleRepository roleRepository;
@Autowired
ClientRepository clientRepository;
@Autowired
CompteBanquaireRepository compteRepository;
@Autowired
InstrumentRepository instrumentRepository;
@Autowired
BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
IMetierClientImpl clientImpl;
@Autowired
TarificationRepository tarificationRepository;
	public static void main(String[] args)  {
		SpringApplication.run(OrdreAchatBourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role r1=new Role("SUPER-ADMIN");
		Role r2=new Role("ADMIN");
		roleRepository.save(r1);
		roleRepository.save(r2);
		List<Role> rs=new ArrayList<>();
		rs.add(r1);rs.add(r2);
		AppUser u=new AppUser("admin1",bCryptPasswordEncoder.encode("admin1"));
		u.setActived(true);
		u.setRoles(rs);
		u.setPrenom("MonPrenom");
		userRepository.save(u);
System.out.println("==================Clients=========================");
for(int i=1;i<=10;i++) {
	CompteBanquaire cp=new CompteBanquaire(new Long((long) (20*Math.random())), 1000*Math.random());
	Client cl=new Client();
	cl.setNom("CL"+i);
	cl.setPrenom("PCL"+i);
	cp.setClient(cl);
	clientRepository.save(cl);
	compteRepository.save(cp);
	Instrument ist=new Instrument(1385*Math.random());
	instrumentRepository.save(ist);
}
clientRepository.findAll().forEach(cl->{
	System.out.println(cl+"\n");
});
System.out.println("==================Comptes=========================");
compteRepository.findAll().forEach(cp->{
	System.out.println(cp+"\n");
});
System.out.println("==================Instruments=========================");
instrumentRepository.findAll().forEach(ist->{
	System.out.println(ist+"\n");
});
//System.out.println(clientImpl.findCompteClient(1L, 5L));
		Tarification t=new Tarification(true, 0, 999, 10);
		Tarification t2=new Tarification(true, 1000, 10000000, 0.8);
		t2.setType("pourcentage");

		t.setType("euro");
		tarificationRepository.save( t);
		tarificationRepository.save( t2);
		System.out.println(tarificationRepository.findTarif("euro"));
	}
}
