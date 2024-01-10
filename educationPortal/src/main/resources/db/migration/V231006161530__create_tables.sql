--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2023-10-06 15:08:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 41308)
-- Name: comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comments (
                                 id bigint NOT NULL,
                                 comment character varying(255),
                                 create_comment date,
                                 task_id bigint,
                                 user_id bigint
);


ALTER TABLE public.comments OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 41307)
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comments_id_seq OWNER TO postgres;

--
-- TOC entry 3406 (class 0 OID 0)
-- Dependencies: 214
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comments_id_seq OWNED BY public.comments.id;


--
-- TOC entry 217 (class 1259 OID 41315)
-- Name: groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.groups (
                               id bigint NOT NULL,
                               name_group character varying(255)
);


ALTER TABLE public.groups OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 41314)
-- Name: groups_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.groups_id_seq OWNER TO postgres;

--
-- TOC entry 3407 (class 0 OID 0)
-- Dependencies: 216
-- Name: groups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.groups_id_seq OWNED BY public.groups.id;


--
-- TOC entry 219 (class 1259 OID 41322)
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
                              id bigint NOT NULL,
                              item_name character varying(255),
                              group_id bigint
);


ALTER TABLE public.items OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 41321)
-- Name: items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_id_seq OWNER TO postgres;

--
-- TOC entry 3408 (class 0 OID 0)
-- Dependencies: 218
-- Name: items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.items_id_seq OWNED BY public.items.id;


--
-- TOC entry 220 (class 1259 OID 41328)
-- Name: items_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items_users (
                                    item_id bigint NOT NULL,
                                    users_id bigint NOT NULL
);


ALTER TABLE public.items_users OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 41412)
-- Name: posts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.posts (
                              id bigint NOT NULL,
                              create_date date,
                              description character varying(255),
                              post_title character varying(255)
);


ALTER TABLE public.posts OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 41411)
-- Name: posts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.posts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.posts_id_seq OWNER TO postgres;

--
-- TOC entry 3409 (class 0 OID 0)
-- Dependencies: 228
-- Name: posts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.posts_id_seq OWNED BY public.posts.id;


--
-- TOC entry 222 (class 1259 OID 41332)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
                              id bigint NOT NULL,
                              name character varying(255)
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 41331)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- TOC entry 3410 (class 0 OID 0)
-- Dependencies: 221
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 224 (class 1259 OID 41339)
-- Name: tasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tasks (
                              id bigint NOT NULL,
                              dead_line date,
                              description character varying(255),
                              status character varying(255),
                              title_task character varying(255),
                              group_id bigint,
                              item_id bigint,
                              CONSTRAINT tasks_status_check CHECK (((status)::text = ANY ((ARRAY['Назначено'::character varying, 'Отправлено'::character varying, 'Оценено'::character varying])::text[])))
);


ALTER TABLE public.tasks OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 41338)
-- Name: tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tasks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tasks_id_seq OWNER TO postgres;

--
-- TOC entry 3411 (class 0 OID 0)
-- Dependencies: 223
-- Name: tasks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;


--
-- TOC entry 226 (class 1259 OID 41349)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
                              id bigint NOT NULL,
                              email character varying(255),
                              first_name character varying(255),
                              is_banned boolean NOT NULL,
                              last_name character varying(255),
                              password character varying(255),
                              group_id bigint
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 41348)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3412 (class 0 OID 0)
-- Dependencies: 225
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 227 (class 1259 OID 41357)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
                                    user_id bigint NOT NULL,
                                    roles_id bigint NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- TOC entry 3211 (class 2604 OID 41311)
-- Name: comments id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments ALTER COLUMN id SET DEFAULT nextval('public.comments_id_seq'::regclass);


--
-- TOC entry 3212 (class 2604 OID 41318)
-- Name: groups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups ALTER COLUMN id SET DEFAULT nextval('public.groups_id_seq'::regclass);


--
-- TOC entry 3213 (class 2604 OID 41325)
-- Name: items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items ALTER COLUMN id SET DEFAULT nextval('public.items_id_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 41415)
-- Name: posts id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posts ALTER COLUMN id SET DEFAULT nextval('public.posts_id_seq'::regclass);


--
-- TOC entry 3214 (class 2604 OID 41335)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 3215 (class 2604 OID 41342)
-- Name: tasks id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);


--
-- TOC entry 3216 (class 2604 OID 41352)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3386 (class 0 OID 41308)
-- Dependencies: 215
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3388 (class 0 OID 41315)
-- Dependencies: 217
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.groups (id, name_group) VALUES (1, 'IUTEk20-1');
INSERT INTO public.groups (id, name_group) VALUES (2, 'Admin');
INSERT INTO public.groups (id, name_group) VALUES (3, 'Teacher');
INSERT INTO public.groups (id, name_group) VALUES (4, 'IUTEk20-2');


--
-- TOC entry 3390 (class 0 OID 41322)
-- Dependencies: 219
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.items (id, item_name, group_id) VALUES (1, 'JAVA', 1);
INSERT INTO public.items (id, item_name, group_id) VALUES (2, 'JS', 1);
INSERT INTO public.items (id, item_name, group_id) VALUES (4, 'RUBY', 4);
INSERT INTO public.items (id, item_name, group_id) VALUES (3, 'Python', 4);
INSERT INTO public.items (id, item_name, group_id) VALUES (5, 'Go', 1);
INSERT INTO public.items (id, item_name, group_id) VALUES (6, 'c++', 1);


--
-- TOC entry 3391 (class 0 OID 41328)
-- Dependencies: 220
-- Data for Name: items_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.items_users (item_id, users_id) VALUES (1, 3);
INSERT INTO public.items_users (item_id, users_id) VALUES (2, 3);
INSERT INTO public.items_users (item_id, users_id) VALUES (3, 5);
INSERT INTO public.items_users (item_id, users_id) VALUES (4, 5);


--
-- TOC entry 3400 (class 0 OID 41412)
-- Dependencies: 229
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.posts (id, create_date, description, post_title) VALUES (3, '2023-11-04', 'this portal use all university
', 'new portal');


--
-- TOC entry 3393 (class 0 OID 41332)
-- Dependencies: 222
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO public.roles (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO public.roles (id, name) VALUES (3, 'ROLE_TEACHER');


--
-- TOC entry 3395 (class 0 OID 41339)
-- Dependencies: 224
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tasks (id, dead_line, description, status, title_task, group_id, item_id) VALUES (2, '2023-09-30', 'qwe', 'Назначено', 'Dza', 4, 3);
INSERT INTO public.tasks (id, dead_line, description, status, title_task, group_id, item_id) VALUES (3, '2023-09-30', 'asd', 'Назначено', 'Dz', 1, 1);


--
-- TOC entry 3397 (class 0 OID 41349)
-- Dependencies: 226
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, email, first_name, is_banned, last_name, password, group_id) VALUES (1, 'ayan@mail.ru', 'Ayan', false, 'Nurgali', '$2a$12$bOdPwXUyPDdY.M13WpHB/.xrCKXoXOp8J5u/9ykdQnxaQnJOqPBQ6', 1);
INSERT INTO public.users (id, email, first_name, is_banned, last_name, password, group_id) VALUES (4, 'asd@mail.ru', 'Asd', false, 'asd', '$2a$12$bOdPwXUyPDdY.M13WpHB/.xrCKXoXOp8J5u/9ykdQnxaQnJOqPBQ6', 4);
INSERT INTO public.users (id, email, first_name, is_banned, last_name, password, group_id) VALUES (3, 'teacher@mail.ru', 'Teacher', false, 'Teacher', '$2a$12$bOdPwXUyPDdY.M13WpHB/.xrCKXoXOp8J5u/9ykdQnxaQnJOqPBQ6', 3);
INSERT INTO public.users (id, email, first_name, is_banned, last_name, password, group_id) VALUES (2, 'Admin@mail.ru', 'Admin', false, 'Admin', '$2a$12$bOdPwXUyPDdY.M13WpHB/.xrCKXoXOp8J5u/9ykdQnxaQnJOqPBQ6', 2);
INSERT INTO public.users (id, email, first_name, is_banned, last_name, password, group_id) VALUES (5, 'qwe@mail.ru', 'qwe', false, 'qwe', '$2a$12$bOdPwXUyPDdY.M13WpHB/.xrCKXoXOp8J5u/9ykdQnxaQnJOqPBQ6', 3);


--
-- TOC entry 3398 (class 0 OID 41357)
-- Dependencies: 227
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO public.users_roles (user_id, roles_id) VALUES (2, 2);
INSERT INTO public.users_roles (user_id, roles_id) VALUES (3, 3);
INSERT INTO public.users_roles (user_id, roles_id) VALUES (4, 1);
INSERT INTO public.users_roles (user_id, roles_id) VALUES (5, 3);


--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 214
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comments_id_seq', 2, true);


--
-- TOC entry 3414 (class 0 OID 0)
-- Dependencies: 216
-- Name: groups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.groups_id_seq', 4, true);


--
-- TOC entry 3415 (class 0 OID 0)
-- Dependencies: 218
-- Name: items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.items_id_seq', 6, true);


--
-- TOC entry 3416 (class 0 OID 0)
-- Dependencies: 228
-- Name: posts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.posts_id_seq', 3, true);


--
-- TOC entry 3417 (class 0 OID 0)
-- Dependencies: 221
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- TOC entry 3418 (class 0 OID 0)
-- Dependencies: 223
-- Name: tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tasks_id_seq', 3, true);


--
-- TOC entry 3419 (class 0 OID 0)
-- Dependencies: 225
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 11, true);


--
-- TOC entry 3220 (class 2606 OID 41313)
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- TOC entry 3222 (class 2606 OID 41320)
-- Name: groups groups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);


--
-- TOC entry 3224 (class 2606 OID 41327)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- TOC entry 3232 (class 2606 OID 41419)
-- Name: posts posts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id);


--
-- TOC entry 3226 (class 2606 OID 41337)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 3228 (class 2606 OID 41347)
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- TOC entry 3230 (class 2606 OID 41356)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3236 (class 2606 OID 41380)
-- Name: items_users fk1eu6j2agwsugqm0v9wgduibw2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items_users
    ADD CONSTRAINT fk1eu6j2agwsugqm0v9wgduibw2 FOREIGN KEY (item_id) REFERENCES public.items(id);


--
-- TOC entry 3241 (class 2606 OID 41405)
-- Name: users_roles fk2o0jvgh89lemvvo17cbqvdxaa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3235 (class 2606 OID 41370)
-- Name: items fk63behc5nfeo9wgt1vvplfnl6b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT fk63behc5nfeo9wgt1vvplfnl6b FOREIGN KEY (group_id) REFERENCES public.groups(id);


--
-- TOC entry 3233 (class 2606 OID 41365)
-- Name: comments fk8omq0tc18jd43bu5tjh6jvraq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3242 (class 2606 OID 41400)
-- Name: users_roles fka62j07k5mhgifpp955h37ponj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fka62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id) REFERENCES public.roles(id);


--
-- TOC entry 3237 (class 2606 OID 41375)
-- Name: items_users fkc8yhjmuu48v96jebmhveiy85r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items_users
    ADD CONSTRAINT fkc8yhjmuu48v96jebmhveiy85r FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 3240 (class 2606 OID 41395)
-- Name: users fkemfuglprp85bh5xwhfm898ysc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkemfuglprp85bh5xwhfm898ysc FOREIGN KEY (group_id) REFERENCES public.groups(id);


--
-- TOC entry 3238 (class 2606 OID 41385)
-- Name: tasks fkgo5e9jsb7dv0e6qcvmx7iuhpk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fkgo5e9jsb7dv0e6qcvmx7iuhpk FOREIGN KEY (group_id) REFERENCES public.groups(id);


--
-- TOC entry 3234 (class 2606 OID 41360)
-- Name: comments fki7pp0331nbiwd2844kg78kfwb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT fki7pp0331nbiwd2844kg78kfwb FOREIGN KEY (task_id) REFERENCES public.tasks(id);


--
-- TOC entry 3239 (class 2606 OID 41390)
-- Name: tasks fkssvwmqh5fdjd6y4778fb0jn02; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fkssvwmqh5fdjd6y4778fb0jn02 FOREIGN KEY (item_id) REFERENCES public.items(id);


-- Completed on 2023-10-06 15:08:54

--
-- PostgreSQL database dump complete
--

