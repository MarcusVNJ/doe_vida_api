package com.doevida.core.domain;

import com.doevida.core.domain.enums.State;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "endereco")
public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "cep")
        private String zipCode;

        @Column(name = "descricao")
        private String description;

        @Column(name = "numero")
        private Short number;

        @Column(name = "bairro")
        private String neighborhood;

        @Column(name = "cidade")
        private String city;

        @JdbcTypeCode(SqlTypes.VARCHAR)
        @Enumerated(EnumType.STRING)
        @Column(name = "estado")
        private State state;


        public Address(Long id, String zipCode, String description, Short number, String neighborhood, String city, State state) {
                this.id = id;
                this.zipCode = zipCode;
                this.description = description;
                this.number = number;
                this.neighborhood = neighborhood;
                this.city = city;
                this.state = state;
        }

        public Long getId() {
                return id;
        }

        public String getZipCode() {
                return zipCode;
        }

        public String getDescription() {
                return description;
        }

        public Short getNumber() {
                return number;
        }

        public String getNeighborhood() {
                return neighborhood;
        }

        public String getCity() {
                return city;
        }

        public State getState() {
                return state;
        }

        public void setState(State state) {
                this.state = state;
        }
}
