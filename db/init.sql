CREATE TABLE public.user_info (
	uuid varchar(255) NOT NULL,
	birth date NULL,
	email varchar(255) NULL,
	first_name varchar(255) NULL,
	gender varchar(255) NULL,
	last_name varchar(255) NULL,
	CONSTRAINT user_info_pkey PRIMARY KEY (uuid)
);

INSERT INTO public.user_info(uuid, birth, email, first_name, gender, last_name)VALUES('1', '1985/8/8', 'robert.yen@linecorp.com', 'Robert', 'Male', 'Yen');
INSERT INTO public.user_info(uuid, birth, email, first_name, gender, last_name)VALUES('2', '1990/10/10', 'cid.change@linecorp.com', 'Cid', 'Male', 'Change');
INSERT INTO public.user_info(uuid, birth, email, first_name, gender, last_name)VALUES('3', '1993/4/5', 'miki.lai@linecorp.com', 'Miki', 'Female', 'Lai');
INSERT INTO public.user_info(uuid, birth, email, first_name, gender, last_name)VALUES('4', '1993/8/8', 'sherry.lai@linecorp.com', 'Sherry', 'Female', 'Chen');
INSERT INTO public.user_info(uuid, birth, email, first_name, gender, last_name)VALUES('5', '1950/12/22', 'peter.wang@linecorp.com', 'Peter', 'Male', 'Wang');

