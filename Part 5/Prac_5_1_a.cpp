#include<iostream>
#include<cstdlib>
using namespace std;

//STACK OF ANY TYPE USING ARRAYS
template<typename T>
class Stack
{
    private:
    T *arr[100];
    int top;
    int size;

    public:

    Stack(int size)
    {
        this->size=size;
        *arr=new T[size];
        top=-1;
    }
    bool isfull()
    {
        if(top==size-1)
        return true;
        return false;
    }
    bool isempty()
    {
        if(top==-1)
        return true;
        return false;
    }
    void push(T var)
    {
        if(isfull())
        {
            cout<<"Stack is full"<<endl<<"Element cannot be inserted";
            return;
        }
        top++;
        *arr[top]=var;
    }
    T pop()
    {
        if(isempty())
        {
            cout<<"Stack is empty";
            exit(0);
        }
        T ans=*arr[top];
        top--;
        return ans;
    }

};

template<typename T>
void menu(Stack<T> s)
{
    while (true)
    {
        cout<<endl<<"[0]Exit"<<endl<<"[1]push"<<endl<<"[2]pop"<<endl<<"Enter your choice:";
        int choice;
        cin>>choice;

        switch (choice)
        {
            case 0:
            {
                cout<<"Thank You";
                exit(0);
            }
            case 1:
            {
                T num;
                cout<<"Enter an element:";
                cin>>num;
                s.push(num);
                break;
            }
            case 2:
            {
                cout<<s.pop();
                break;
            }
            default:
            {
                cout<<"Invalid option";
                break;
            }
        }
    }
    return ;
}

int main(int argc, char const *argv[])
{
    int size;
    cout<<"Enter the maximum limit of the stack:";
    cin>>size;

    Stack<double> s(size);
    menu(s);
    return 0;
}