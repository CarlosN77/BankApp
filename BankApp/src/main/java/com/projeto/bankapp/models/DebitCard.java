package com.projeto.bankapp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DebitCard extends Cartao {

    private String tipo;

    public DebitCard(ClientDTO clientDTO, Account account, int numerodecartao, String tipo) {
        super(clientDTO, account, numerodecartao);
        this.tipo = tipo;
    }

}
