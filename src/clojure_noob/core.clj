(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(println "Boka baki khana kahlo")
(println "Boka baki" "khana kahlo")


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



(do (println "Helo boka")
    (println "Second Print")
    (println "Third Print")
    "Finally returning"
    )
(if true
  (do ()))


(when true
  (println "Print Statement")
  (println "Second Statement")
  (println "Third Statement")
  "Final Return"
  )

((and (= 1 0) +) 1 2 3)


;; def for variables
;; defn for funcitions
;; and fn for lambda functions
;; #(* %1 %2 3 ) short lambda function


;; A demo function which is given for understanding of different datastructrures and
;; and all the features of the languge
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
(matching-part {:name "left-turn" :size 22})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)]) ;; This function stops duplicates 
                     );; Into is being used to insert values to the vector
               )))))

;; input planned for the above function

;;Testing into , it is used to concat a sequence into a vector
(into [1 2 3 4] [ 4 ])
(into [1 2 3 4] '( 4 )) ;; Raw list is being used here .



(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


;; Looping can be done by loop recur construct
#"regular-expression" ;; Regex example
;; about loop construct
;; Loop has just initializers
;;(loop [var1 val1 var2 val2  var3 [demovec] ] ) ;; first iternation is implicit
;; After that recur function is used to fill in these values

;; Do times is a good thing
(dotimes [x 100]
    (doto (Thread. (fn []
                     (let [resource @resource]
                       ;; use the resource here ...
                       ))
      .start)))

(re-find #"^left-" "left-to-rot")

(defn PrintList
  "Just a print function"
  [lst]
  (loop [rem lst double [] triple []]
    (if (empty? rem)
      (list double triple)
      (let [[ele & remaning] rem] 
        (if (nil? ele)
          (println "ele is nil")
          (println (str "ele is " ele)))
         (recur remaning  (conj double (* ele 2)) (conj triple (* ele 3)))))))

(empty? [])

(PrintList [1 2 3 4 5 6])


;; Reduce function
(reduce + [1 2 3 4])

;; Reduce can take optional value 
(reduce + 12 [1 2 3 4 5])

;; hashmap
(hash-map 1 2 3 3)

;; dec maker , this is a practise of clojure

(defn dec-maker
  "Dec maker clojure"
  [byNum]
  #(- % byNum)
  )


(def dec9 (dec-maker 9))

(dec9 22)

(map inc [1 1 2 3])



(defn mapset
  "Map set"
  [fn inputvec]
  (set (map fn inputvec))
  )



(mapset inc [1 1 2 3])


(:a {:a 1 :b 2})

(reduce (fn [key val] (println (str "Print  -" key " %-% "  val))) {:a 1 :b 2 :c 3})


(second '(1 2 3 4))
(first '(1 2 3 4))

(cons 2 (lazy-seq #(3)))


(into {} (map identity {:sunlight-reaction "Glitter!"}))
;; Example of into


(defn my-conj
  [target & additions] ;; Notice that additions is an array ; therefore into works
  (into target additions))


;; Example of apply 
(apply max [0 1 2])
(max [0 1 2]) ;; Max returns max of args 


;; Customs conj implementation 

(defn my-into
  [target additions]
  (apply conj target additions))


;; This implementation explodes the additions with the help of apply .
;; This gets applied to target with the help of conj
;; Giving us INTO


;; Partials
(def add10 (partial + 10))


(def add-missing-elements
  (partial conj ["water" "earth" "air"]))


(add-missing-elements 1 2 3)


;;+ 10 partial can be implemented as 

(defn my-partial
  [partialized-fn & args]
  (fn [& more-args]
    (apply partialized-fn (into args more-args))))


;; A complement function


(def addComp (complement +)) ;; This function only returns nil because add always returns value


;; Compliment empty? to create a function full 

(def hasVal? (complement empty?))


(hasVal? [])


(defn my-compliment
  [fun]
  (fn [& args]
    (not (apply fun args))
    ))


(def hasValBoka? (my-compliment empty?))

(hasValBoka? [])
(hasValBoka? [1 2 3])





;; The god damn powers of slurp and split

;; Slurp is used to injest data from sources be it fs and webpages
;;Spit is used to throw out data to ex. File system
()

(Integer. "45")

(list (1))
(into () (1))

(defn personalcomp
  "My personal Comp function"
  [& fnlst]
  (fn [& args]
    (first (reduce #(list (apply %2 %1)) args (reverse fnlst)))
    )
  )

(def myc (personalcomp inc +))

(myc 5 6 8 9 23)

(reduce #(or (println %1 %& ) (str %1 %&)) "Hi" '("Hello" "world"))



;; Comp function is used to from g(x) = f1(f2(f2...(fn(x))))
(def comp_ex (comp inc + ))



;; Memoize ,
;; This keyword caches the result of expensive function calls 
(defn sleepy-identity
  "Returns the given value after 1 second"
  [x]
  (Thread/sleep 1000)
  x)


(sleepy-identity "Heloo worl") ;; Returns result after 1 second 


;; Lets cache the result of this function call with memoize 

(def memoized-sleepy-identity (memoize sleepy-identity))


(memoized-sleepy-identity "Hello World") ;;First result is taking 1 second

(memoized-sleepy-identity "Hello World") ;; This is instant otherwise it will take time.


