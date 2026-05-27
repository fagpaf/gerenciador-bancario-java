isReplica :: String -> Int -> Char -> Bool
isReplica [] x c
    | x == 0    = True
    | otherwise = False
-- passa 'ss' (o resto sem o primeiro char)
isReplica (s:ss) x c
    | s == c    = isReplica ss (x-1) c
    | otherwise = False

main = do
    a <- getLine
    b <- getLine
    c <- getChar
    let result = isReplica a (read b) c
    print result