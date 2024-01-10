import React, { useEffect, useState } from 'react';
import ProjectBoxInfo from '../../component/project/ProjectBoxInfo';
import styled from 'styled-components';

const StyledUserCreatedDiv = styled.div`
        padding-left: 20px;

        & > #cnt {
            height: 80px;
            line-height: 80px;
            color: var(--black-color);
            
            & > span {
                color: var(--red-color);
                font-weight: 500;
                margin-right: 3px;
                margin-left: 3px;
            }
        }

        & > #project_items {
            width: 1050px;
            display: flex;
            flex-wrap: wrap;
        }
`;

const UserCreated = () => {

    const [projectsCnt, setProjectsCnt] = useState(0);
    const [myProjectsList, setMyProjectsList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/userpage/created")
        .then(resp => resp.json())
        .then(data => {
            console.log(data);
            setMyProjectsList(data.myProjectsList);
            console.log(myProjectsList);
            setProjectsCnt(data.projectsCnt);
        });    
    }, [])

    return (
        <StyledUserCreatedDiv>
            <div id="cnt">프로젝트가 <span>{projectsCnt}</span>개 있습니다.</div>
            <div id="project_items">
                {
                    myProjectsList.map((vo) => {
                        return <ProjectBoxInfo key={vo.projectNo} project={vo}/>
                    })
                }
            </div>
        </StyledUserCreatedDiv>
    );
};

export default UserCreated;