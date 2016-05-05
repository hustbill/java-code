scala> val lists = List(((1,52),7), ((1,82),6))
lists: List[((Int, Int), Int)] = List(((1,52),7), ((1,82),6))

scala> lists map { case ((a,b),c ) => (a,b,c) }
res7: List[(Int, Int, Int)] = List((1,52,7), (1,82,6))