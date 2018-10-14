#include <iostream>
using namespace std;

//Object oriented programming
//class declaration
//encapsulation
class CEngine{ // abstract
	public: // totally visible
		CEngine(){// default constructor

		}
		CEngine(string _type,string _combustible, string _mark
			,string _model, string _hp){ // customized constructor
			type = _type;
			combustible = _combustible;
			mark = _mark;
			model = _model;
			hp = _hp;
		}
		//publics methods
		string getMark(){
			return mark;
		}
		void setMark(string _mark){
			mark = _mark;
		}

	private: // only owner
		string type;
		string combustible;
		string mark;
		string model;
		string hp;
	protected: // shared only member (family -> hierarchy)

};

class CGearBox{
	public:
		string type;
	unsigned char velocities;
		string mark;
	private:

	protected:
};

class CTire{
	public:
		string mark;
	float radius;
		string cocada;
		string color;
	private:
	protected:
};

class CSit{
 public:
	string material;
	string color;
	string type;
	private:
	protected:
};


class CRadio{
public:
	string mark;
	string type;
	int potencia;

private:
protected:
};

class CSteeringWheel{
public:
	string mark;
	bool graduable;
	string material;
	bool controls;
private:
protected:

};

//composition
class CCar{
	string mark;
	string model;
	string fabricationYear;
	string color;
	string type;
	CEngine engine;
	CSit* sits;
	CGearBox gearBox;
	CTire* tires;
	CRadio radio;
	CSteeringWheel steeringWheel;
};



int main(){
	CEngine mitsubishi; // object instance / object creation
	CEngine ecotec("Lineal","Diesel","Chevrolet","A345","80000");
	//cout<<mitsubishi.mark<<endl; // unexpected behaviour
	//cout<<ecotec.mark<<endl; // chevrolet
	//mitsubishi.mark ="Mitsubishi"; // assign -> bad guideline , it breaks encapsulation
	//cout<<mitsubishi.mark<<endl; // unexpected behaviour
	mitsubishi.setMark("Mitsubishi"); // we use public method to access private attributes
	cout<<mitsubishi.getMark()<<endl;
	return 0;
}
