#include<iostream>
#include<cstdlib>
using namespace std;

//STACK USING LINKEDLIST
template<typename T>
struct node{
    T data;
    node *link;
};

template<typename T>
class LinkedList{
    private :
    node<T> *head = new node<T>;

    public :
    LinkedList() : head(NULL) {}

    void push(T data)
    {
        node<T> *n = new node<T> ;
        n->data=data;

        if(head==NULL)
        {
            n->link=NULL;
        }
        else
        {
            n->link=head;
        }
        head=n;
        return ;
    }

    T pop()
    {
        if(head==NULL)
        {
            cout<<"Stack is empty";
            exit(0);
        }

        node<T> *n = new node<T>;
        n=head;
        head=head->link;

        T data=n->data;
        delete n;
        return data;
    }

};

template<typename T>
void menu(LinkedList<T> s)
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
    LinkedList<int> stack;
    menu(stack);
    return 0 ;
}