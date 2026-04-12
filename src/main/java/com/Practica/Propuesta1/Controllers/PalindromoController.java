package com.Practica.Propuesta1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
*Controlador para verificar palindromos
*/
@RestController
public class PalindromoController {

    /**
     *Endpoint para verificar si una palabra es un palindromo o no
     * @param word la palabra verificar
     * @return Un mensaje indicando si la palabra es un palindromo o no
     */
    @GetMapping("/validar-palindromo/{word}")
    public String palindromo(@PathVariable String word){
        if ( isPalindrome(word)) {
            return "La palabra " + word + " es un palindrono";
        }else {
            return "La palabra " + word + " no es un palindrono";
        }
    }

    /**
     *Metodo para verificar si una palabra es un palindromo
     * @param word La palabra a verificar
     * @return Un mensaje indicando si una palabra es un palindromo o no
     */
    private boolean isPalindrome(String word){
        int lenght = word.length();
        for (int i = 0; i < lenght / 2; i++) {
            if(word.charAt(i) != word.charAt(lenght - i -1)){
                return false;
            }
        }
        return true;
    }
}
