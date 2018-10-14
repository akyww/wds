#include <iostream>

class CEngine{ // abstract
    public: // totally visible
        CEngine(){// default constructor

        }
        CEngine(std::string _type,std::string _combustible, std::string _mark
            ,std::string _model, std::string _hp){ // customized constructor
            type = _type;
            combustible = _combustible;
            mark = _mark;
            model = _model;
            hp = _hp;
        }
        //publics methods
        const std::string& getMark() const{
            return mark;
        }
        void setMark(std::string _mark){
            mark = _mark;
        }

    private: // only owner
        std::string type;
        std::string combustible;
        std::string mark;
        std::string model;
        std::string hp;
    protected: // shared only member (family -> hierarchy)

};

class CGearBox{
    public:
        CGearBox(){

        }
        CGearBox(std::string _type,unsigned char _vel,std::string _mark){
            type= _type;
            velocities= _vel;
            mark = _mark;
        }

    const std::string& getMark() const {
        return mark;
    }

    void setMark(const std::string& mark) {
        this->mark = mark;
    }

    const std::string& getType() const {
        return type;
    }

    void setType(const std::string& type) {
        this->type = type;
    }

    unsigned char getVelocities() const {
        return velocities;
    }

    void setVelocities(unsigned char velocities) {
        this->velocities = velocities;
    }

    private:
            std::string type;
            unsigned char velocities;
            std::string mark;
    protected:
};

class CTire{
    public:
        std::string mark;
        float radius;
        std::string cocada;
        std::string color;
        CTire(std::string _mark,float _radius,std::string _cocada, std::string _color){
        mark = _mark;
        radius=_radius;
        cocada= _cocada;
        color=_color;
    }
    private:
    protected:
};

class CSit{
 public:
    CSit(){

    }
    CSit(std::string _material,std::string _color, std::string _type){
        material = _material;
        color=_color;
        type= _type;
    }

    const std::string& getColor() const {
        return color;
    }

    void setColor(const std::string& color) {
        this->color = color;
    }

    const std::string& getMaterial() const {
        return material;
    }

    void setMaterial(const std::string& material) {
        this->material = material;
    }

    const std::string& getType() const {
        return type;
    }

    void setType(const std::string& type) {
        this->type = type;
    }

    private:
    std::string material;
    std::string color;
    std::string type;
    protected:
};


class CRadio{
public:
    std::string mark;
    std::string type;
    int potencia;

private:
protected:
};

class CSteeringWheel{
public:
    std::string mark;
    bool graduable;
    std::string material;
    bool controls;
private:
protected:

};

//composition
class CCar{

    private:
    std::string mark;
    std::string model;
    std::string fabricationYear;
    std::string color;
    std::string type;
    CEngine engine;
    CSit* sits;
    CGearBox gearBox;
    CTire* tires;
    int numTires;

    //CTire* tires;
    CRadio radio;
    CSteeringWheel steeringWheel;
public:


    CCar(){

    }
    CCar(std::string _mark,std::string _model,std::string _fabrication,
        std::string _color,std::string _type, CEngine _engine,CSit* _sit,
        CGearBox _gearBox,CTire* _tire,int numTires){//, CTire* _tire,CRadio _radio,CSteeringWheel steering
        mark=_mark;
        model=_model;
        fabricationYear=_fabrication;
        color = _color;
        type = _type;
        engine = _engine;
        sits= _sit;
        gearBox=_gearBox;
        this->numTires=numTires;
//        tires=new CTire[numTires];
  //      for(int i=0;i<numTires;i++){
    //        tires[i]=_tire[i];

        }
        //tires = _tire;
        //radio=_radio;
        //steeringWheel= steering;
    }

    const std::string& getColor() const {
        return color;
    }

    void setColor(const std::string& color) {
        this->color = color;
    }

    const CEngine& getEngine() const {
        return engine;
    }

    void setEngine(const CEngine& engine) {
        this->engine = engine;
    }

    const std::string& getFabricationYear() const {
        return fabricationYear;
    }

    void setFabricationYear(const std::string& fabricationYear) {
        this->fabricationYear = fabricationYear;
    }

    const CGearBox& getGearBox() const {
        return gearBox;
    }

    void setGearBox(const CGearBox& gearBox) {
        this->gearBox = gearBox;
    }

    const std::string& getMark() const {
        return mark;
    }

    void setMark(const std::string& mark) {
        this->mark = mark;
    }

    const std::string& getModel() const {
        return model;
    }

    void setModel(const std::string& model) {
        this->model = model;
    }

    const CRadio& getRadio() const {
        return radio;
    }

    void setRadio(const CRadio& radio) {
        this->radio = radio;
    }

    const CSit* getSits() const {
        return sits;
    }

    void setSits(CSit* sits) {
        this->sits = sits;
    }

    const CSteeringWheel& getSteeringWheel() const {
        return steeringWheel;
    }

    void setSteeringWheel(const CSteeringWheel& steeringWheel) {
        this->steeringWheel = steeringWheel;
    }

    const CTire* getTires() const {
        return tires;
    }

    void setTires(CTire* tires) {
        this->tires = tires;
    }

    const std::string& getType() const {
        return type;
    }

    void setType(const std::string& type) {
        this->type = type;
    }


};


int main(){
    CEngine mitsubishi; // object instance / object creation
    CEngine ecotec("Lineal","Diesel","Chevrolet","A345","80000");
    //std::cout<<mitsubishi.mark<<std::endl; // unexpected behaviour
    //std::cout<<ecotec.mark<<std::endl; // chevrolet
    //mitsubishi.mark ="Mitsubishi"; // assign -> bad guideline , it breaks encapsulation
    //std::cout<<mitsubishi.mark<<std::endl; // unexpected behaviour
    mitsubishi.setMark("Mitsubishi"); // we use public method to access private attributes
    std::cout<<mitsubishi.getMark()<<std::endl;
    /********** CREATING OBJECTS THROUGH OBJECTS***************/
    CCar tico;
    CSit sit("Cuero","Marron","Deportivo");
    //CSit*psit=sit; // pointer to an created object
    //int * a = new int[2];// array
    // int *a = new int(4); // one element
    //CSit* psit = new CSit("Cuero","Negro","Clasico"); // new object
    CCar fantastico("JAC","VH+","2016","Amarillo","SUV",ecotec,new CSit("Cuero","Negro","Clasico"),
        CGearBox("Mecanico",'6',"FORCE"), new CTire("XXX", 55, "XXX" , "XXX"), 6);
    std::cout<<"Las caracteristica del auto de Elvis: "<<std::endl;
    std::cout<<"Tiene un auto de color "<<fantastico.getColor()<< " y es de marca "<<fantastico.getMark()<<std::endl;
    std::cout<<"Su motor es de marca "<<fantastico.getEngine().getMark()<<std::endl;
    std::cout<<"Tiene un caja de cambios "<<fantastico.getGearBox().getType()<<" y tiene "<<fantastico.getGearBox().getVelocities()<<" velocidades"<<std::endl;
    std::cout<<"Tiene asientos de color "<< fantastico.getSits()->getColor()<< " y son de "<<fantastico.getSits()->getMaterial()<<std::endl;
    //std::cout<<"El Auto tiene 6"<<fantastico.getTires()<<std::endl;
    return 0;
}
