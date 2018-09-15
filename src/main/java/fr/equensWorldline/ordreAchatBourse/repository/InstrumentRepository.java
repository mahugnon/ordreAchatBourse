package fr.equensWorldline.ordreAchatBourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.equensWorldline.ordreAchatBourse.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
public Instrument findInstrumentByCodeInstrument(Long id);
}
