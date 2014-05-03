(ns game-of-life.core)

; any cell with fewer than 2 live neighbours dies, as if caused by under-population
; any cell with two or three live neighbours lives on to the next generation
; any live cell with more than 3 live neighbours dies, as if by overcrowding
; any dead cell with exactly 3 live neighbours becomes a live cell, as if by reproduction

; count live neighbours
; count dead neighbours
; use sets?
(def world [[2 1 2] [1 1 2] [2 1 1]])

(defn live-neighbours
  [outer-index index cell world]
   (let [max-x (.length world) max-y (.length (first world))]
      max-y))

(defn change
  [outer-index index cell world]
    (live-neighbours outer-index index cell world))

(defn turn
  [index cell world]
    (map #(change index %1 %2 world) (iterate inc 0) cell))

(defn live
  [world]
    (vec (map #(turn %1 %2 world) (iterate inc 0) world)))

(defn -main
  [& args]
    (live world))
