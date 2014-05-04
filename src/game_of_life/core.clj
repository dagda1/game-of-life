(ns game-of-life.core)

; any cell with fewer than 2 live neighbours dies, as if caused by under-population
; any cell with two or three live neighbours lives on to the next generation
; any live cell with more than 3 live neighbours dies, as if by overcrowding
; any dead cell with exactly 3 live neighbours becomes a live cell, as if by reproduction

; count live neighbours
; https://github.com/bbatsov/clojure-style-guide
; http://clojure.org/cheatsheet
(def world [[2 1 2] [1 1 2] [2 1 1]])

(def compass-points [[0 1][1 1][1 0][1 -1][0 -1][-1 1][-1 0][-1 -1]])

(defn live-neighbours
  [outer-index index cell world]
    (reduce + (map (fn[[x y]]
            (let [cord-x (+ outer-index x)
                  cord-y (+ index y)
                  next-cell (get-in world [cord-x cord-y])]
                  (if next-cell
                    (if (= next-cell 2) 1 0)
                    0))) compass-points)))

(defn change
  [outer-index index cell world]
    (let [live-count (live-neighbours outer-index index cell world)]
      (cond
        (< live-count 2) 1
        (or (= live-count 2) (= live-count 3)) 2
        (and (= cell 2) (> live-count 3)) 1
        (and (= cell 2) (= live-count 3)) 2
        :else 1)))

(defn turn
  [index cell world]
    (map #(change index %1 %2 world) (iterate inc 0) cell))

(defn live
  [world]
    (vec (map #(turn %1 %2 world) (iterate inc 0) world)))

(defn -main
  [& args]
    (live world))
