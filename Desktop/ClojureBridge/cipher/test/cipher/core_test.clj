(ns cipher.core-test
  (:require [cipher.core :as core]
            [midje.sweet :refer :all]))


(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (tabular
         (core/to-int ?char) => ?result
         ?char ?result
         \a    0
         \b    1
         \c    2
         \d    3))

(facts "recebe um número e retorna seu caractere correspondente"
       (tabular
         (core/to-char ?num) => ?result
         ?num ?result
         0     \a
         1     \b
         2     \c))


(facts "receber um número e uma letra e retornar a letra n posições à frente"
       (tabular
         (core/shift ?char ?num) => ?result
         ?char ?num ?result
         \a    2    \c
         \b    2    \d
         \c    3    \f
         \a    0    \a))

(facts "encriptar uma string e retornar o seu correspondente"
       (tabular
         (core/encriptar ?string ?num) => ?result
         ?string ?num ?result
         "apple" 20   "ujjfy"
         "abc"   1    "bcd"))

(facts "recebe uma string encriptada e decripta"
       (tabular
         (core/decriptar ?string ?num) => ?result
         ?string ?num ?result
         "ujjfy" 20   "apple"
         "bcd"   1    "abc"
         ))

(facts "recebe uma string com caracteres especiais e letras maiusculas e retorna uma string sem caracteres especiais"
       (tabular
         (core/get-letters ?string) => ?result
         ?string   ?result
         "Haydu7/" "haydu"
         "hHHH"    "hhhh"
         ))

(facts "encriptar uma string e retornar o seu correspondente"
       (tabular
         (core/caesar-encrypt ?string ?num) => ?result
         ?string ?num ?result
         "Apple7379237" 20   "ujjfy"
         "Abc"   1    "bcd"))

(facts "recebe uma string e uma letra e conta sua frenquencia na string"
       (tabular
         (core/conta-letras ?string ?letra) => ?result
          ?string   ?letra  ?result
          "Abacaxi" \a     3
          "Limao"   \l     1
         ))



