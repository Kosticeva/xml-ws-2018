export class Accomodation {

    constructor(
        public id: number,
        public name: string,
        public description: string,
        public address: string,
        public city: string,
        public country: string,
        public averageGrade: number,
        public price: number,
        public agentUsername: string,
        public type: string,
        public category: string,
        public services: string[]
    ) {}

}
