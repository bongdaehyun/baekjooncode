var map=null;

function solution(rows, columns, queries) {
    var answer = [];
    map=new Array(rows+1);
    for(let i=0;i<rows+1;i++){
        map[i]=new Array(columns+1).fill(0);
    }
    let num=1;
    for(let i=1;i<=rows;i++){
        for(let j=1;j<=columns;j++){
            map[i][j]=num++;
        }
    }
   
    for(let i=0;i<queries.length;i++)
        answer.push(lotation(queries[i]));
    return answer;
}
function lotation(query){
    let [x1,y1,x2,y2]=query;
    const temp=map[x1][y1];
    const arr=[temp];
    //반시계방향
    for(let i = x1; i < x2; i++){
        map[i][y1] = map[i+1][y1];
        arr.push(map[i][y1]);
    }
    for(let j = y1; j < y2; j++){
        map[x2][j] = map[x2][j+1];
        arr.push(map[x2][j]);
    }
    for(let i = x2; i > x1; i--){
        map[i][y2] = map[i-1][y2];
        arr.push(map[i][y2]);
    }
    for(let j = y2; j > y1; j--){
        map[x1][j] = map[x1][j-1];
        arr.push(map[x1][j]);
    }
    
    map[x1][y1+1]=temp;
    //console.log(arr);
    return Math.min(...arr);
}
