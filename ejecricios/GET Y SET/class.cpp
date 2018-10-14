#include <iostream>
using namespace std;
//Object oriented programming
//class declaration
//encapsulation
class CEngine{
	public: // totally visible
	CEngine(){
	}
	CEngine(string _type,string _combustible,string _mark,string _model,string _hp){
		type=_type;
		combustible=_combustible;
		mark=_mark;
		model=_model;
		hp=_hp;
	}
	std::string type;
	std::string combustible;
	std::string mark;
	std::string model;
	std::string hp;

	std::string getType(){
        return type;
	}
	void setType(string _type){
        this->type = _type;
	}

	std::string getCombustible(){
        return combustible;
	}
	void setCombustible(string _combustible){
        this->combustible=_combustible;
	}
	std::string getMark(){
        return mark;
	}
	void setMark(string _mark){
        this->mark=_mark;
	}
	std::string getModel(){
        return model;
	}
	void setModel(string _model){
        this->model=_model;
	}
    std::string getHp(){
        return hp;
    }
    void setHp(string _hp){
        this->hp=_hp;
    }
	private: // only owner

	protected: // shared only member (family -> hierarchy)
};
class CGearBox{
	public:
		CGearBox(){
		}
		CGearBox(string _type,int _velocities,string _mark){
			type=_type;
			velocities=_velocities;
			mark=_mark;
		}
	std::string type;
	int velocities;
	std::string mark;
	private:

	protected:
};
class CTire{
	public:
		CTire(){
		}
		CTire(string _mark, float _radius,string _cocada,string _color){
			mark=_mark;
			radius=_radius;
			cocada=_cocada;
			color=_color;
		}
	std::string mark;
	float radius;
	std::string cocada;
	std::string color;
	private:
	protected:
};
class CSit{
 public:
 	CSit(){
 	}
 	CSit(string _material,string _color,string _type){
 		material=_material;
 		color=_color;
 		type=_type;
 	}
	std::string material;
	std::string color;
	std::string type;
	private:
	protected:
};
class CRadio{
    public:
    	CRadio(){
    	}
    	CRadio(string _mark,string _type,int _potencia){
    		mark=_mark;
    		type=_type;
    		potencia=_potencia;
    	}
	std::string mark;
	std::string type;
	int potencia;
    private:
    protected:
};
class CSteeringWheel{
    public:
    	CSteeringWheel(){
    	}
    	CSteeringWheel(string _mark,bool _graduable,string _material,bool _controls){
    		mark=_mark;
    		graduable=_graduable;
    		material=_material;
    		controls=_controls;
    	}
	std::string mark;
	bool graduable;
	std::string material;
	bool controls;
    private:
    protected:
};
class CSuspension{
    public:
    	CSuspension(){
    	}
    	CSuspension(string _tipo,string _marca,string _eje){
    		tipo=_tipo;
    		marca=_marca;
    		eje=_eje;
    	}
	std::string tipo;
	std::string marca;
	std::string eje;
    private:
    protected:
};


//composition
class CCar{
	std::string mark;
	std::string model;
	std::string fabricationYear;
	std::string color;
	std::string type;
	CEngine engine;
	CSit* sits;
	CGearBox gearBox;
	CTire* tires;
	CRadio radio;
	CSteeringWheel steeringWheel;
	CSuspension* suspension;
};

int main(){
	CEngine ecotec("Lineal","Disel","Chervrolet","A345","80000");
	CSuspension suspe("tipos","tipo","tipo");
	CRadio rad("Mark","Type",18000);
	CTire tir("mark",15.2,"floar","floar");

	CSteeringWheel steeringWhe("Mark",true,"carton",true);
	CGearBox box("Mark",15,"hoal");
	CSit si("Material","Color","Type");

    cout<<ecotec.getType()<<endl;
    cout<<ecotec.getHp()<<" La marca es: "<<ecotec.getMark()<<endl;
	cout<<steeringWhe.mark<<endl;
	return 0;
}
