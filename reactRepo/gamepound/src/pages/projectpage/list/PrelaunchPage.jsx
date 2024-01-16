import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import ProjectListBoxInfo from '../../../component/project/ProjectListBoxInfo';

const StyledAllDiv = styled.div`
    width: 100%;
    .inner {
        width: 1200px;
        margin: 0 auto;
        padding: 20px;
        & > div:first-child{
            & > div:last-child{
                & > span{
                    color: var(--red-color);
                }
                margin-top: 20px;
                margin-bottom: 25px;
            }
            
        }
        & > div:last-child{
            display: flex;
            flex-wrap: wrap;
        }
    }
`;

const PrelaunchPage = () => {

    const [prelaunchVoList, setPrelaunchVoList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/list/prelaunch")
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            console.log("prelaunchPage > fetch");
            setPrelaunchVoList(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, []);

    return (
        <StyledAllDiv>
            <div className='inner'>
                <div>
                    <div><span>20</span>개의 프로젝트가 있습니다.</div>
                </div>
                <div>
                    {
                        prelaunchVoList.map((vo)=>{
                            return(<ProjectListBoxInfo project={vo}/>);
                        })
                    }
                </div>
            </div>
        </StyledAllDiv>
    );
};

export default PrelaunchPage;