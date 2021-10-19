//
//  main.swift
//  test2
//
//  Created by 이진하 on 2021/10/08.
//

import Foundation

//let arr:[Int] = [2,3,4,5,6,7,8,9]
//
//let results:[String] = arr.map { num in
////    return (1..<10).map({"\(num) * \($0) = \(num * $0)" })
//    return (1..<10).reduce(into: "") { res, i in
//        res = res + "\(num) * \(i) = \(num * i) " + "\n"
//    }
//}
//
//
//let resultString = results.joined()
//print(resultString)



//최대공약수 ,최대공배수
//func LCD(num1:Int , num2:Int) -> Int {
    
//    var a = num1
//    var b = num2
//    var temp = 0
//
//    while a % b != 0 {
//        temp = a
//        a %= b
//        b = temp
//    }
        
//    return temp
    
//    if num1 % num2 == 0 { return num2 }
//    else {
//        return LCD(num1: num2, num2: num1%num2)
//    }
//}
//
//let inputs = readLine()!.split(separator: " ").map({Int(String($0))!})
//
//let a = inputs[0]
//let b = inputs[1]
//
//let lcd = LCD(num1: max(a, b), num2: min(a, b))
//
//print("최대공약수 : \(lcd)")
//print("최소공배수 : \(a*b / lcd)")
    
    
    


let list:[String] = ["a" , "e", "i", "o" , "u"]
var indexes:[Int] = []

var input:[String] = Array(arrayLiteral: readLine()!)

//모음 위치 저장
(0..<input.count).forEach { i in
    if list.contains(where: {input[i] == $0}) {
        indexes.append(i)
    }
}
//모음 배열 생성
let characters = input.filter({ num in
    
    list.contains(where: { num == $0 }) == true
    
}).reversed().map({String($0)})
var cIdx = 0

indexes.forEach { idx in
    
    input[idx] = characters[cIdx]
    cIdx += 1
}

print(input.joined())
