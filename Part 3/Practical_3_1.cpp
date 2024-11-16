#include<iostream>
using namespace std;

template<typename T>
struct node{
    T data;
    node *link;

    node() : data(NULL) , link(NULL) {}
    node(T val) : data(val) , link(NULL) {}
};

template<typename T>
class Linkedlist{
    private:
    node<T> *head,*temp;
    int count;

    public:
    Linkedlist() :head(NULL) ,count(0) {}

    void Insert_at_front(T data)
    {
        count++;

        temp=new node<T>(data);
        temp->link=this->head;
        head=temp;
        return ;
    }

    void Delete_at_end()
    {
        count--;
        if(head==NULL)
        {
            cout<<"List is empty";
            return;
        }
        if(head->link==NULL)
        {
            delete head->link;
            head->link=NULL;
            return ;
        }

        temp=this->head;
        while(temp->link->link!=NULL)
        {
            temp=temp->link;
        }
        node<T> *remove=new node<T>;
        remove=temp->link->link;
        temp->link=NULL;
        delete remove;
        remove=NULL;

        return ;
    }
    void Delete_at_position(int position_from_end)
    {
        count--;
        if(head==NULL || position_from_end>count || position_from_end<0)
        {
            cout<<"Invalid value";
            return;
        }

        int position=count-position_from_end;

        temp=this->head;
        for(int i=0;i<position;i++)
        {
            temp=temp->link;
        }
        node<T> *remove=new node<T>;
        remove=temp->link;
        temp->link=temp->link->link;
        delete remove;
        remove=NULL;
        
        return ;
    }

    void Delete_all()
    {
        count=0;
        node<T> *remove=new node<T>;
        temp=this->head;

        while(temp!=NULL)
        {
            remove=temp;
            temp=temp->link;
            delete remove;
            remove=NULL;
        }
        head=NULL;
        return ;
    }

    void Print()
    {
        temp=this->head;
        while(temp!=NULL)
        {
            cout<<temp->data<<"->";
            temp=temp->link;
        }
        cout<<"NULL"<<endl;
        // cout<<count;
        return ;
    }
};

int main()
{
    Linkedlist<int> list;
    list.Insert_at_front(68);
    list.Insert_at_front(69);
    list.Print();
    list.Delete_at_end();
    list.Print();
    list.Insert_at_front(55);
    list.Insert_at_front(0);
    list.Insert_at_front(69);
    list.Print();
    list.Delete_at_position(2);
    list.Print();
    list.Delete_all();
    list.Print();
    return 0;
}