(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(println "Boka baki khana kahlo")


(defn truck
  "Truck function"
  []
  (println "I am a large truck I roll Bhoooooooooooooo"))


truck

93
1.2
1/5

{:boka "baki" 
:monka "Mummy"}

(hash-map :hello "darling")
(get (hash-map :hello "darling") :hello )

(def nicemp {:a "my life" :b {:c "sub" :d "vals"}})

(get nicemp :a)
(get-in nicemp [:b :d])
(nicemp :a)
(nicemp [:b :d]) ; Invalid

(:a nicemp) ;;Only works with keywords

(:x nicemp "Some default val")


;; Vector

(vector "hello" "Boka" "how " "are" "You")

(get [2 1 4 5] 2)

(conj [1 2 3 4] 5) ;; Adding values to the vector end


;; Lists are like emacs 
(nth '(:a :b :c) 0 )


(list 1 "two" {3 4})

;;Adding values to beginning of list
(conj '(2 3 4 5) 1 )

;;HashSet

(hash-set 1 2 3 4 4 4 )
;alternate syntax , does not allow negative values
#{1 2 3 4}

;set from vector

(set [1 2 3 4])
(hash-set [1 2 3 4])

;;Membership can be checked by get, contains?, or by a keyword
(contains? #{1 2 3 4} 4)
(get #{1 2 3 4} 4)
(get #{1 2 3 4} 9)
(:4 #{:1 :2 :3 :4})

