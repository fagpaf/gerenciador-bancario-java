type Comando = String
type Valor = Int

executa :: [(Comando, Valor)] -> Int
executa lista = execHelper lista 0

execHelper :: [(Comando, Valor)] -> Int -> Int
execHelper [] acc = acc
execHelper ((cmd, val):ss) acc
    | cmd == "Divide" && val == 0 = -666
    | cmd == "Multiplica"         = execHelper ss (acc * val)
    | cmd == "Soma"               = execHelper ss (acc + val)
    | cmd == "Subtrai"            = execHelper ss (acc - val)
    | cmd == "Divide"             = execHelper ss (acc `div` val)

main = do
    a <- getLine
    let result = executa (read a)
    print result