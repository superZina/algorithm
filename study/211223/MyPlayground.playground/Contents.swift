import Foundation

let inputs = readLine()!.split(separator: " ").map{ Int($0)! }
let A = inputs[0]
let B = inputs[1]
let C = inputs[2]
 
//let A = 2100000000
//let B = 9
//let C = 10

if B >= C { print(-1) }
else {
    let result: Double = Double(A) / Double((C - B))
    print(Int(result+1))
}
RawRepresentable
