CREATE OR REPLACE FUNCTION delete_actor_data() RETURNS TRIGGER AS $$
BEGIN
  IF OLD.type_id = (SELECT id FROM Employee_type WHERE type = 'Актер') THEN
    DELETE FROM Achievement WHERE actor_id = OLD.id;
    DELETE FROM Actor_playing_role WHERE actor_id = OLD.id;
    DELETE FROM Actor_tour WHERE actor_id = OLD.id;
    DELETE FROM Actor WHERE id = OLD.id;
  END IF;
  RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_actor_data_trigger
  BEFORE DELETE ON Employee
  FOR EACH ROW
  EXECUTE FUNCTION delete_actor_data();

-------------------------------------------------
CREATE OR REPLACE FUNCTION delete_author()
RETURNS TRIGGER AS $$
BEGIN

    DELETE FROM Subscription WHERE Subscription.author_id = OLD.id;
    DELETE FROM Performance WHERE Performance.author_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER cascade_delete_author
    BEFORE DELETE ON Author
    FOR EACH ROW
    EXECUTE FUNCTION delete_author();

------------------------------------------------
CREATE OR REPLACE FUNCTION delete_director()
RETURNS TRIGGER AS $$
BEGIN

    DELETE FROM Director_performance WHERE director_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER cascade_delete_director
    BEFORE DELETE ON Director
    FOR EACH ROW
    EXECUTE FUNCTION delete_director();

----------------------------------------------------
--CREATE OR REPLACE FUNCTION delete_ticket_places()
--RETURNS TRIGGER AS $$
--BEGIN
--    DELETE FROM Ticket_place WHERE ticket_id = OLD.id;
--    RETURN OLD;
--END;
--$$ LANGUAGE plpgsql;
--
--CREATE TRIGGER cascade_delete_ticket_places
--AFTER DELETE ON Ticket
--FOR EACH ROW
--EXECUTE FUNCTION delete_ticket_places();

----------------------------------------------------------
CREATE OR REPLACE FUNCTION delete_date_of_tour()
RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM Actor_tour WHERE date_of_tour_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER cascade_delete_date_of_tour
    BEFORE DELETE ON Date_of_tour
    FOR EACH ROW
    EXECUTE FUNCTION delete_date_of_tour();

--------------------------------------------------------

CREATE OR REPLACE FUNCTION delete_role()
RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM Actor_playing_role WHERE role_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER cascade_delete_role
    BEFORE DELETE ON Role
    FOR EACH ROW
    EXECUTE FUNCTION delete_role();

--------------------------------------------------------

CREATE OR REPLACE FUNCTION delete_performance()
RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM Date_performance WHERE performance_id = OLD.id;
--    DELETE FROM Ticket WHERE performance_id = OLD.id;
    DELETE FROM Director_performance WHERE performance_id = OLD.id;
    DELETE FROM Date_of_tour WHERE performance_id = OLD.id;
    DELETE FROM Role WHERE performance_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER cascade_delete_performance
    BEFORE DELETE ON Performance
    FOR EACH ROW
    EXECUTE FUNCTION delete_performance();

----------------------------------------------------------
CREATE OR REPLACE FUNCTION delete_genre()
RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM Author WHERE genre_id = OLD.id;
    DELETE FROM Subscription WHERE genre_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER cascade_delete_genre
    BEFORE DELETE ON Genre
    FOR EACH ROW
    EXECUTE FUNCTION delete_genre();
