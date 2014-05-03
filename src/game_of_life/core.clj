(ns game-of-life.core)

; any cell with fewer than 2 live neighbours dies, as if caused by under-population
; any cell with two or three live neighbours lives on to the next generation
; any live cell with more than 3 live neighbours dies, as if by overcrowding
; any dead cell with exactly 3 live neighbours becomes a live cell, as if by reproduction

; http://www.wikihow.com/Make-the-Conway%27s-Game-of-Life-Cellular-Automaton
(def world [[2 1 2] [1 1 2] [2 1 1]])

(defn turn
  [row]
    row)

(defn live
  []
    (for [cell world] (turn cell)))

(defn -main
  [& args]
    (live))

; count live neighbours
; count dead neighbours
