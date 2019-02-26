(ns ppm-project.core)

(def foo
  (let [x     200
        y     200
        head (str "P3\n" x " " y "\n255\n")
        matrix   (clojure.string/join (for [j (range (dec y) -1 -1)
                                          i (range 0 x)
                                          :let  [r (/ i x)
                                                 g (/ j y)
                                                 b 0.6
                                                 ir (int (* 255.99 r))
                                                 ig (int (* 255.99 g))
                                                 ib (int (* 255.99 b))]]
                                      (str ir " " ig " " ib "\n")))]
    (spit "i1.ppm" head :append true)
    (spit "i1.ppm" matrix :append true)) )
