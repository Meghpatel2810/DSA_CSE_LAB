#include<iostream>
using namespace std;

int main()
{
    int n;
    int count = 0;
    cin >> n;

    int arr[n];
    int res1[n / 2];
    int res2[n / 2];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    int k;
    cin >> k;
    if(n % 2 == 0)
    {
        int fal[n] = {0};
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int temp = (arr[i] + arr[j]) % k;
                if (temp == 0)
                {
                    if (fal[i] == 0 && fal[j] == 0)
                    {
                        res1[count] = arr[i];
                        res2[count] = arr[j];
                        count++;
                        fal[i] = 1;
                        fal[j] = 1;
                    }
                }
            }
        }

        if (count == n / 2)
        {
            for (int i = 0; i < n / 2; i++)
            {
                cout << "(" << res1[i] << "," << res2[i] << ")" << endl;
            }
        }
        else
        {
            cout << "-1" << endl;
        }
    }
    else
    {
        cout << "-1" << endl;
    }
    return 0;
}