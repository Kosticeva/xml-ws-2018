export class AccomodationDTO {

    public agentUsername: string;

    public name: string;
    public description: string;
    public maxPersons: number;

    public categoryId: number;
    public typeId: number;

    public images: Array<string>;

    public address: string;
    public city: string;
    public country: string;

    constructor(
    ) {
        this.name = 'test';
        this.description = 'test';
        this.maxPersons = 3;
        this.categoryId = 1;
        this.typeId = 1;
        this.images = new Array();
        this.address = 'test';
        this.city = 'test';
        this.country = 'test';
    }
}