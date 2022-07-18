db.createUser(
    {
        user: "userdb",
        pwd: "userdbpwd",
        roles: [
            { role: "readWrite", db: "userdb" }
        ]
    }
);

db = new Mongo().getDB("userdb");

db.createCollection('UserInfo', { capped: false });

db.UserInfo.insert([{
  "uuid": "1",
  "birth": new ISODate("1985-08-08T00:00:00Z"),
  "email": "robert.yen@linecorp.com",
  "firstName": "Robert",
  "gender": "Male",
  "lastName": "Yen"
},{
  "uuid": "2",
  "birth": new ISODate("1990-10-10T00:00:00Z"),
  "email": "cid.change@linecorp.com",
  "firstName": "Cid",
  "gender": "Male",
  "lastName": "Change"
},{
  "uuid": "3",
  "birth":  new ISODate("1993-04-05T00:00:00Z"),
  "email": "miki.lai@linecorp.com",
  "firstName": "Miki",
  "gender": "Female",
  "lastName": "Lai"
},{
  "uuid": "4",
  "birth": new ISODate("1993-08-08T00:00:00Z"),
  "email": "sherry.lai@linecorp.com",
  "firstName": "Sherry",
  "gender": "Female",
  "lastName": "Chen"
},{
  "uuid": "5",
  "birth": new ISODate("1950-12-22T00:00:00Z"),
  "email": "peter.wang@linecorp.com",
  "firstName": "Peter",
  "gender": "Male",
  "lastName": "Wang"
}]);

