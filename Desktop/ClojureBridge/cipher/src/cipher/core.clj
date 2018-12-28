(ns cipher.core
  (:require [clojure.string :as string]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn g [x y]
   (+ (* x 10) y ))


(defn to-int
  "recebe uma letra minúscola e retorna sua posição no alfabeto: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  "recebe um número e retorna seu caractere correspondente"
  [numero]
  (let [ascii-a (int \a)]
    (char (+ numero ascii-a)))
  )

(defn shift
  "recebe um numero e um caractere e retorna seu caractere n posicoes a frente "
  [letra numero]

  (let [numAlfabeto 26]
    (-> (to-int letra)
       (+ numero)
       (mod numAlfabeto)
       to-char))
  )


(defn encriptar
  "recebe uma string e retorna uma string com n posicoes à frente"
  [string numero]
  (->> (mapv #(shift % numero) string)
      (apply str))
  )

(defn decriptar
  "recebe uma string encripatada e um numero e retona a string decriptada"
  [string numero]
  (->> (mapv #(shift % (* -1 numero)) (clojure.string/lower-case string))
       (apply str))
  )

(defn get-letters
  "recebe uma string com caracteres especiais e letras maiusculas e retorna uma string sem caracteres especiais"
  [string]
  (->>
    (filterv #(Character/isLetter %) string)
    (apply str)
    string/lower-case))

(defn caesar-encrypt
  [string numero]
  (-> (get-letters string)
      (encriptar numero))
  )

(defn put-animais
  [animal som]
  (let [animais {:pato "quack"}]
    (assoc animais :gato "miau"
                    animal som)
    ))

(defn conta-letras
  [string letra]
  (->>
    (get-letters string)
    (filterv #(= % letra))
    count
    )
  )





