package old;
 Executing: INSERT INTO "users" ("id","created_at","updated_at") VALUES (1788010,'2015-10-24 22:42:50.0Z','2015-10-24 22:42:50.0Z') RETURNING *; (worker=null)
 
 
 
  INSERT INTO "users" ("id","created_at","updated_at") VALUES 
  
 
 
 
[2015-10-24T22:42:50.165Z]  INFO: Securitas/28239 on zhoutekiMacBook-Air.local: Executing: INSERT INTO "roles_users" ("user_id","role_id","created_at","updated_at") VALUES (1788010,2,'20150801','2015-10-24 22:42:50.0Z') RETURNING *; (worker=null)
[2015-10-24T22:42:50.165Z]  INFO: Securitas/28239 on zhoutekiMacBook-Air.local: Executing: INSERT INTO "distributors" ("personal_sponsor_distributor_id","user_id","created_at","updated_at","id") VALUES (1788010,1788010,'20150801','2015-10-24 22:42:50.0Z',1788010) RETURNING *;