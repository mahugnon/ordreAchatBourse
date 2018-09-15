package fr.equensWorldline.ordreAchatBourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.equensWorldline.ordreAchatBourse.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
