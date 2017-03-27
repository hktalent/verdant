/**
 * @Time Complexity:	O(n)
 * @Space Complexity:	O(1)
 */
#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        return nums.size() > set<int>(nums.begin(), nums.end()).size();        
    }
};

int main() {
	return 0;
}