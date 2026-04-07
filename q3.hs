charParaInt :: Char -> Int
charParaInt '0' = 0
charParaInt '1' = 1

btoi :: String -> Int
btoi s = sum (map multiplica pares)
  where
    pares      = zip digitos potencias
    digitos    = map charParaInt (reverse s)
    potencias  = map (2^) [0..]
    multiplica (d, p) = d * p

main = do
    s <- getLine
    let result = btoi s
    print result