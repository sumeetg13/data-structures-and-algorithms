#include <iostream>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0) , left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x , TreeNode* left , TreeNode* right) : val(x), left(left), right(right) {}
};

int binarysearch(vector<int> &v, int target){
    int left = 0;
    int right = v.size() - 1;
    while (left <= right)
    {
        int mid = left + (right - left) / 2;
        if(v[mid] == target){
            return mid;
        }
        else if(target > v[mid]){
            left = mid+1;
        }
        else {
            right = mid-1;
        }
    }
    return -1;
}
// range is -x < all numbers < +x
void countSort(vector<int> &v, int x){
    vector<int> freq(2*x + 1);
    for(int i=0; i< v.size(); i++){
        freq[v[i] + x] += 1;
    }
    int j=0;
    for(int i=0; i< 2*x+1; i++){
        if(freq[i] !=0){
            while(freq[i]--){
                v[j] = i-x;
                j++;
            }
        }
    }
}

int main(){
    vector<int> v ;
    int t;
    printf("enter t:");
    cin >> t ;
    for(int i = 0; i< t ; i++){
        int c ;
        cin >> c;
        v.push_back(c);
    }
    for(int val : v){
        cout << val << " ";
    }
    cout << endl;
    printf("find target:");
    int target;
    cin >> target;
    // int found = binarysearch(v, target);
    // if(found == -1){
    //     printf("Not found!!");
    // }
    // else{
    //     cout << "found " << v[found] << "at " << found << endl;
    // }
    countSort(v, target);
    for(int val : v){
        cout << val << " ";
    }
    return 0;
};