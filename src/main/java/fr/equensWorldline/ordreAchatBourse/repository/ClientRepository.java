package fr.equensWorldline.ordreAchatBourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.equensWorldline.ordreAchatBourse.entities.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {
public Client findClientByIdClient(Long id);
}
