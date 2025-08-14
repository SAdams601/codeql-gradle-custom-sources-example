/**
 * @name Finds all classes in the DB
 * @kind problem
 * @description Find all classes in the DB
 * @problem.severity info
 * @precision medium
 * @id ql/found-classes
 */

import java

from Class c
where c.fromSource()
select c, "Is a Class"
