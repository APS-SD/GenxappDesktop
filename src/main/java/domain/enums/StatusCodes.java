/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.enums;

/**
 *
 * @author iedash
 */
public enum StatusCodes {
    
    OK(200), ERROR(200), CREATED(3);

    private final int valor;
    
    StatusCodes(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
    return valor;
    }
}
