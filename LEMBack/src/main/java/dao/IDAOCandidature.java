package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Candidature;

public interface IDAOCandidature extends JpaRepository<Candidature, Integer>{

}
