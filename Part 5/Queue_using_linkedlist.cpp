#include<iostream>
using namespace std;

template<typename T>
struct node
{
    T data;
    node *link;
    node() : data(NULL) , link(NULL) {}
    node(T val) : data(val) , link(NULL) {}
};

template<typename T>
class Linkedlist{
    private:
    node<T> *head=new node<T>;

    public:
    Linkedlist() : head(NULL) {}

    void enque(T data)
    {
        if(head==NULL)
        {
            head=new node<T>(data);
            return ;
        }
        node<T> *temp=head;

        while(temp->link!=NULL)
        {
            temp=temp->link;
        }
        temp->link=new node<T>(data);

        return;
    }
    T deque()
    {
        if(head==NULL)
        {
            cout<<"Linkedlist is empty";
            exit(0);
        }
        node<T> *temp=head;
        head=head->link;
        T data=temp->data;
        temp=NULL;
        return data;
    }
};

template<typename T>
void menu(Linkedlist<T> queue)
{
    int queries;
    cin>>queries;
    for(int i=0;i<queries;i++)
    {
        int choice;
        cin>>choice;
        
        switch(choice)
        {
            case 1:
            {
                int data;
                cin>>data;
                queue.enque(data);
                break;
            }
            case 2:
            {
                cout<<queue.deque();
                break;
            }
            default:
            {
                return;
            }
        }
    }
}

int main()
{
    Linkedlist<int> queue;
    menu<int>(queue);
    return 0;
}