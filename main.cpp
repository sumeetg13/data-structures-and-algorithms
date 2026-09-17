#include <iostream>

using namespace std;

class Animal {
public : 
    virtual void speak() {
        cout << "..." << endl;
    }
};

class Dog : public Animal {
public :
    void speak() override {
        cout << "bhow bhow" << endl;
    }
};

int main(){
    Animal* dog = new Dog();
    dog->speak();
}